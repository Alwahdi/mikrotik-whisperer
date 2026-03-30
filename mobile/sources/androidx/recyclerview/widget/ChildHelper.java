package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

class ChildHelper {
    private static final boolean DEBUG = false;
    private static final int REMOVE_STATUS_IN_REMOVE = 1;
    private static final int REMOVE_STATUS_IN_REMOVE_IF_HIDDEN = 2;
    private static final int REMOVE_STATUS_NONE = 0;
    private static final String TAG = "ChildrenHelper";
    final Bucket mBucket;
    final Callback mCallback;
    final List<View> mHiddenViews;
    private int mRemoveStatus = 0;
    private View mViewInRemoveView;

    interface Callback {
        void addView(View view, int i);

        void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i);
    }

    ChildHelper(Callback callback) {
        this.mCallback = callback;
        this.mBucket = new Bucket();
        this.mHiddenViews = new ArrayList();
    }

    private void hideViewInternal(View child) {
        this.mHiddenViews.add(child);
        this.mCallback.onEnteredHiddenState(child);
    }

    private boolean unhideViewInternal(View child) {
        if (!this.mHiddenViews.remove(child)) {
            return false;
        }
        this.mCallback.onLeftHiddenState(child);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void addView(View child, boolean hidden) {
        addView(child, -1, hidden);
    }

    /* access modifiers changed from: package-private */
    public void addView(View child, int index, boolean hidden) {
        int offset;
        if (index < 0) {
            offset = this.mCallback.getChildCount();
        } else {
            offset = getOffset(index);
        }
        this.mBucket.insert(offset, hidden);
        if (hidden) {
            hideViewInternal(child);
        }
        this.mCallback.addView(child, offset);
    }

    private int getOffset(int index) {
        if (index < 0) {
            return -1;
        }
        int limit = this.mCallback.getChildCount();
        int offset = index;
        while (offset < limit) {
            int diff = index - (offset - this.mBucket.countOnesBefore(offset));
            if (diff == 0) {
                while (this.mBucket.get(offset)) {
                    offset++;
                }
                return offset;
            }
            offset += diff;
        }
        return -1;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void removeView(View view) {
        int i = this.mRemoveStatus;
        if (i == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        } else if (i != 2) {
            try {
                this.mRemoveStatus = 1;
                this.mViewInRemoveView = view;
                int index = this.mCallback.indexOfChild(view);
                if (index < 0) {
                    this.mRemoveStatus = 0;
                    this.mViewInRemoveView = null;
                    return;
                }
                if (this.mBucket.remove(index)) {
                    unhideViewInternal(view);
                }
                this.mCallback.removeViewAt(index);
                this.mRemoveStatus = 0;
                this.mViewInRemoveView = null;
            } catch (Throwable th) {
                this.mRemoveStatus = 0;
                this.mViewInRemoveView = null;
                throw th;
            }
        } else {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
    }

    /* access modifiers changed from: package-private */
    public void removeViewAt(int index) {
        int i = this.mRemoveStatus;
        if (i == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        } else if (i != 2) {
            try {
                int offset = getOffset(index);
                View view = this.mCallback.getChildAt(offset);
                if (view != null) {
                    this.mRemoveStatus = 1;
                    this.mViewInRemoveView = view;
                    if (this.mBucket.remove(offset)) {
                        unhideViewInternal(view);
                    }
                    this.mCallback.removeViewAt(offset);
                    this.mRemoveStatus = 0;
                    this.mViewInRemoveView = null;
                }
            } finally {
                this.mRemoveStatus = 0;
                this.mViewInRemoveView = null;
            }
        } else {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
    }

    /* access modifiers changed from: package-private */
    public View getChildAt(int index) {
        return this.mCallback.getChildAt(getOffset(index));
    }

    /* access modifiers changed from: package-private */
    public void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        for (int i = this.mHiddenViews.size() - 1; i >= 0; i--) {
            this.mCallback.onLeftHiddenState(this.mHiddenViews.get(i));
            this.mHiddenViews.remove(i);
        }
        this.mCallback.removeAllViews();
    }

    /* access modifiers changed from: package-private */
    public View findHiddenNonRemovedView(int position) {
        int count = this.mHiddenViews.size();
        for (int i = 0; i < count; i++) {
            View view = this.mHiddenViews.get(i);
            RecyclerView.ViewHolder holder = this.mCallback.getChildViewHolder(view);
            if (holder.getLayoutPosition() == position && !holder.isInvalid() && !holder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void attachViewToParent(View child, int index, ViewGroup.LayoutParams layoutParams, boolean hidden) {
        int offset;
        if (index < 0) {
            offset = this.mCallback.getChildCount();
        } else {
            offset = getOffset(index);
        }
        this.mBucket.insert(offset, hidden);
        if (hidden) {
            hideViewInternal(child);
        }
        this.mCallback.attachViewToParent(child, offset, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    /* access modifiers changed from: package-private */
    public int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    /* access modifiers changed from: package-private */
    public View getUnfilteredChildAt(int index) {
        return this.mCallback.getChildAt(index);
    }

    /* access modifiers changed from: package-private */
    public void detachViewFromParent(int index) {
        int offset = getOffset(index);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    /* access modifiers changed from: package-private */
    public int indexOfChild(View child) {
        int index = this.mCallback.indexOfChild(child);
        if (index != -1 && !this.mBucket.get(index)) {
            return index - this.mBucket.countOnesBefore(index);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    /* access modifiers changed from: package-private */
    public void hide(View view) {
        int offset = this.mCallback.indexOfChild(view);
        if (offset >= 0) {
            this.mBucket.set(offset);
            hideViewInternal(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* access modifiers changed from: package-private */
    public void unhide(View view) {
        int offset = this.mCallback.indexOfChild(view);
        if (offset < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.mBucket.get(offset)) {
            this.mBucket.clear(offset);
            unhideViewInternal(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public boolean removeViewIfHidden(View view) {
        int i = this.mRemoveStatus;
        if (i == 1) {
            if (this.mViewInRemoveView == view) {
                return false;
            }
            throw new IllegalStateException("Cannot call removeViewIfHidden within removeView(At) for a different view");
        } else if (i != 2) {
            try {
                this.mRemoveStatus = 2;
                int index = this.mCallback.indexOfChild(view);
                if (index == -1) {
                    unhideViewInternal(view);
                    this.mRemoveStatus = 0;
                    return true;
                } else if (this.mBucket.get(index)) {
                    this.mBucket.remove(index);
                    unhideViewInternal(view);
                    this.mCallback.removeViewAt(index);
                    this.mRemoveStatus = 0;
                    return true;
                } else {
                    this.mRemoveStatus = 0;
                    return false;
                }
            } catch (Throwable th) {
                this.mRemoveStatus = 0;
                throw th;
            }
        } else {
            throw new IllegalStateException("Cannot call removeViewIfHidden within removeViewIfHidden");
        }
    }

    static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData = 0;
        Bucket mNext;

        Bucket() {
        }

        /* access modifiers changed from: package-private */
        public void set(int index) {
            if (index >= 64) {
                ensureNext();
                this.mNext.set(index - 64);
                return;
            }
            this.mData |= 1 << index;
        }

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        /* access modifiers changed from: package-private */
        public void clear(int index) {
            if (index >= 64) {
                Bucket bucket = this.mNext;
                if (bucket != null) {
                    bucket.clear(index - 64);
                    return;
                }
                return;
            }
            this.mData &= ~(1 << index);
        }

        /* access modifiers changed from: package-private */
        public boolean get(int index) {
            if (index < 64) {
                return (this.mData & (1 << index)) != 0;
            }
            ensureNext();
            return this.mNext.get(index - 64);
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.mData = 0;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        /* access modifiers changed from: package-private */
        public void insert(int index, boolean value) {
            if (index >= 64) {
                ensureNext();
                this.mNext.insert(index - 64, value);
                return;
            }
            long j = this.mData;
            boolean lastBit = (LAST_BIT & j) != 0;
            long mask = (1 << index) - 1;
            this.mData = (j & mask) | ((j & (~mask)) << 1);
            if (value) {
                set(index);
            } else {
                clear(index);
            }
            if (lastBit || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, lastBit);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean remove(int index) {
            if (index >= 64) {
                ensureNext();
                return this.mNext.remove(index - 64);
            }
            long mask = 1 << index;
            long j = this.mData;
            boolean value = (j & mask) != 0;
            long j2 = j & (~mask);
            this.mData = j2;
            long mask2 = mask - 1;
            this.mData = (j2 & mask2) | Long.rotateRight(j2 & (~mask2), 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return value;
        }

        /* access modifiers changed from: package-private */
        public int countOnesBefore(int index) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                if (index >= 64) {
                    return Long.bitCount(this.mData);
                }
                return Long.bitCount(this.mData & ((1 << index) - 1));
            } else if (index < 64) {
                return Long.bitCount(this.mData & ((1 << index) - 1));
            } else {
                return bucket.countOnesBefore(index - 64) + Long.bitCount(this.mData);
            }
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }
}
