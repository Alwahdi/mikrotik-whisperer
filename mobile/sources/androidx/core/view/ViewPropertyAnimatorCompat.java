package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat {
    static final int LISTENER_TAG_ID = 2113929216;
    Runnable mEndAction = null;
    int mOldLayerType = -1;
    Runnable mStartAction = null;
    private final WeakReference<View> mView;

    ViewPropertyAnimatorCompat(View view) {
        this.mView = new WeakReference<>(view);
    }

    static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
        boolean mAnimEndCalled;
        ViewPropertyAnimatorCompat mVpa;

        ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat vpa) {
            this.mVpa = vpa;
        }

        public void onAnimationStart(@NonNull View view) {
            this.mAnimEndCalled = false;
            if (this.mVpa.mOldLayerType > -1) {
                view.setLayerType(2, (Paint) null);
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVpa;
            if (viewPropertyAnimatorCompat.mStartAction != null) {
                Runnable startAction = viewPropertyAnimatorCompat.mStartAction;
                viewPropertyAnimatorCompat.mStartAction = null;
                startAction.run();
            }
            Object listenerTag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            ViewPropertyAnimatorListener listener = null;
            if (listenerTag instanceof ViewPropertyAnimatorListener) {
                listener = (ViewPropertyAnimatorListener) listenerTag;
            }
            if (listener != null) {
                listener.onAnimationStart(view);
            }
        }

        public void onAnimationEnd(@NonNull View view) {
            int i = this.mVpa.mOldLayerType;
            if (i > -1) {
                view.setLayerType(i, (Paint) null);
                this.mVpa.mOldLayerType = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.mAnimEndCalled) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVpa;
                if (viewPropertyAnimatorCompat.mEndAction != null) {
                    Runnable endAction = viewPropertyAnimatorCompat.mEndAction;
                    viewPropertyAnimatorCompat.mEndAction = null;
                    endAction.run();
                }
                Object listenerTag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                ViewPropertyAnimatorListener listener = null;
                if (listenerTag instanceof ViewPropertyAnimatorListener) {
                    listener = (ViewPropertyAnimatorListener) listenerTag;
                }
                if (listener != null) {
                    listener.onAnimationEnd(view);
                }
                this.mAnimEndCalled = true;
            }
        }

        public void onAnimationCancel(@NonNull View view) {
            Object listenerTag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            ViewPropertyAnimatorListener listener = null;
            if (listenerTag instanceof ViewPropertyAnimatorListener) {
                listener = (ViewPropertyAnimatorListener) listenerTag;
            }
            if (listener != null) {
                listener.onAnimationCancel(view);
            }
        }
    }

    @NonNull
    public ViewPropertyAnimatorCompat setDuration(long value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().setDuration(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat alpha(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().alpha(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat alphaBy(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().alphaBy(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationX(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().translationX(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationY(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().translationY(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat withEndAction(@NonNull Runnable runnable) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                Api16Impl.withEndAction(view2.animate(), runnable);
            } else {
                setListenerInternal(view2, new ViewPropertyAnimatorListenerApi14(this));
                this.mEndAction = runnable;
            }
        }
        return this;
    }

    public long getDuration() {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            return view2.animate().getDuration();
        }
        return 0;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setInterpolator(@Nullable Interpolator value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().setInterpolator(value);
        }
        return this;
    }

    @Nullable
    public Interpolator getInterpolator() {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view == null || Build.VERSION.SDK_INT < 18) {
            return null;
        }
        return Api18Impl.getInterpolator(view2.animate());
    }

    @NonNull
    public ViewPropertyAnimatorCompat setStartDelay(long value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().setStartDelay(value);
        }
        return this;
    }

    public long getStartDelay() {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            return view2.animate().getStartDelay();
        }
        return 0;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotation(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().rotation(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationBy(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().rotationBy(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationX(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().rotationX(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationXBy(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().rotationXBy(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationY(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().rotationY(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationYBy(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().rotationYBy(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleX(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().scaleX(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleXBy(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().scaleXBy(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleY(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().scaleY(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleYBy(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().scaleYBy(value);
        }
        return this;
    }

    public void cancel() {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().cancel();
        }
    }

    @NonNull
    public ViewPropertyAnimatorCompat x(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().x(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat xBy(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().xBy(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat y(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().y(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat yBy(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().yBy(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationXBy(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().translationXBy(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationYBy(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().translationYBy(value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationZBy(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            Api21Impl.translationZBy(view2.animate(), value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationZ(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            Api21Impl.translationZ(view2.animate(), value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat z(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            Api21Impl.z(view2.animate(), value);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat zBy(float value) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            Api21Impl.zBy(view2.animate(), value);
        }
        return this;
    }

    public void start() {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            view2.animate().start();
        }
    }

    @NonNull
    public ViewPropertyAnimatorCompat withLayer() {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                Api16Impl.withLayer(view2.animate());
            } else {
                this.mOldLayerType = view2.getLayerType();
                setListenerInternal(view2, new ViewPropertyAnimatorListenerApi14(this));
            }
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat withStartAction(@NonNull Runnable runnable) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                Api16Impl.withStartAction(view2.animate(), runnable);
            } else {
                setListenerInternal(view2, new ViewPropertyAnimatorListenerApi14(this));
                this.mStartAction = runnable;
            }
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setListener(@Nullable ViewPropertyAnimatorListener listener) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                setListenerInternal(view2, listener);
            } else {
                view2.setTag(LISTENER_TAG_ID, listener);
                setListenerInternal(view2, new ViewPropertyAnimatorListenerApi14(this));
            }
        }
        return this;
    }

    private void setListenerInternal(final View view, final ViewPropertyAnimatorListener listener) {
        if (listener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animation) {
                    listener.onAnimationCancel(view);
                }

                public void onAnimationEnd(Animator animation) {
                    listener.onAnimationEnd(view);
                }

                public void onAnimationStart(Animator animation) {
                    listener.onAnimationStart(view);
                }
            });
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    @NonNull
    public ViewPropertyAnimatorCompat setUpdateListener(@Nullable ViewPropertyAnimatorUpdateListener listener) {
        View view = (View) this.mView.get();
        View view2 = view;
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            ValueAnimator.AnimatorUpdateListener wrapped = null;
            if (listener != null) {
                wrapped = new hv0(listener, view2);
            }
            Api19Impl.setUpdateListener(view2.animate(), wrapped);
        }
        return this;
    }

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static ViewPropertyAnimator withEndAction(ViewPropertyAnimator viewPropertyAnimator, Runnable runnable) {
            return viewPropertyAnimator.withEndAction(runnable);
        }

        @DoNotInline
        static ViewPropertyAnimator withLayer(ViewPropertyAnimator viewPropertyAnimator) {
            return viewPropertyAnimator.withLayer();
        }

        @DoNotInline
        static ViewPropertyAnimator withStartAction(ViewPropertyAnimator viewPropertyAnimator, Runnable runnable) {
            return viewPropertyAnimator.withStartAction(runnable);
        }
    }

    @RequiresApi(18)
    static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        static Interpolator getInterpolator(ViewPropertyAnimator viewPropertyAnimator) {
            return (Interpolator) viewPropertyAnimator.getInterpolator();
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static ViewPropertyAnimator translationZBy(ViewPropertyAnimator viewPropertyAnimator, float value) {
            return viewPropertyAnimator.translationZBy(value);
        }

        @DoNotInline
        static ViewPropertyAnimator translationZ(ViewPropertyAnimator viewPropertyAnimator, float value) {
            return viewPropertyAnimator.translationZ(value);
        }

        @DoNotInline
        static ViewPropertyAnimator z(ViewPropertyAnimator viewPropertyAnimator, float value) {
            return viewPropertyAnimator.z(value);
        }

        @DoNotInline
        static ViewPropertyAnimator zBy(ViewPropertyAnimator viewPropertyAnimator, float value) {
            return viewPropertyAnimator.zBy(value);
        }
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static ViewPropertyAnimator setUpdateListener(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener listener) {
            return viewPropertyAnimator.setUpdateListener(listener);
        }
    }
}
