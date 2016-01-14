package com.zzj.cancridemo;

import android.support.annotation.BinderThread;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.support.annotation.StringRes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by apple on 16/1/14.
 */
public class TestSupportAnnotations {
    // gradle配置
    // compile 'com.android.support:support-annotations:20.0.0'

//    元 Annotation
//    @Documented 是否会保存到 Javadoc 文档中
//    @Retention 保留时间，可选值 SOURCE（源码时），CLASS（编译时），RUNTIME（运行时），默认为 CLASS，值为 SOURCE 大都为 Mark Annotation，这类 Annotation 大都用来校验，比如 Override, Deprecated, SuppressWarnings
//    @Target 可以用来修饰哪些程序元素，如 TYPE, METHOD, CONSTRUCTOR, FIELD, PARAMETER 等，未标注则表示可修饰所有
//    @Inherited 是否可以被继承，默认为 false

    // 三种类型的注解
    // 1.Nullness注解
    // 2.资源类型注解
    // 3.IntDef和StringDef注解

    // 使用@NonNull注解修饰的参数不能为null
    void sayHello(@NonNull String s) {

    }

    void sayHelllo(@StringRes int id) {

    }

    private int flavour;
    public static final int VANILLA = 0;
    public static final int CHOCOLATE = 1;
    public static final int STRAWBERRY = 2;

    @IntDef(flag = true, value = {VANILLA, CHOCOLATE, STRAWBERRY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flavour {
    }

    @Flavour
    public int getFlavour() {
        return flavour;
    }

    public void setFlavour(@Flavour int flavour) {
        this.flavour = flavour;
    }

    @RequiresPermission(allOf = {
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public static final void copyFile(String dest, String source) {

    }

//    @BinderThread
//    android.R.animator.
//    android.R.fraction

//    AnimatorRes	// android3.0 新增的一种动画
//        AnimRes
//    AnyRes
//            ArrayRes
//    AttrRes
//            BoolRes
//    ColorRes
//            DimenRes
//    DrawableRes
//            FractionRes	// 百分数 10%
//    IdRes
//            IntegerRes
//    InterpolatorRes
//            LayoutRes
//    MenuRes
//            PluralsRes // 用在一个单词或者短语在单数和复数时拼写不一样的情况。
//    RawRes
//            StringRes
//    StyleableRes
//            StyleRes
//    TransitionRes
//            XmlRes
//
//    MainThread
//            UiThread
//    WorkerThread
//            BinderThread
//
//    NonNull
//            Nullable
//
//    IntDef
//            StringDef
//
//    IntRange
//            FloatRange
//
//    ColorInt
//            CallSuper
//    CheckResult
//            VisibleForTesting
//    RequiresPermission
//    Size 数组的属性
//    Keep

}
