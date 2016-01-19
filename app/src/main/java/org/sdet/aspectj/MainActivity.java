package org.sdet.aspectj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zzj.cancridemo.R;

/**
 * Created by apple on 16/1/19.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        functionA();
        functionB();
    }

    private void functionB() {
        dummy();
    }

    private void dummy() {
    }

    private void functionA() {
        dummy();
    }


    private void method4Execution() {
        System.out.println("in method method4Execution");
    }

    private void method4Call() {
        System.out.println("in method method4Call");
    }
}
