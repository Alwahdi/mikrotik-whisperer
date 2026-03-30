package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.List;

interface d {
    void a();

    List<Animator.AnimatorListener> b();

    void c();

    boolean d();

    void e(ExtendedFloatingActionButton.f fVar);

    AnimatorSet f();

    void g();

    void onAnimationStart(Animator animator);
}
