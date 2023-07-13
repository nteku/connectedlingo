package com.maid.connectedlingo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /**
         * <androidx.cardview.widget.CardView
        android:id="@+id/cardView"
        android:layout_width="363dp"
        android:layout_height="125dp"
        android:background="@color/white"
        android:layout_marginTop="60dp"
        app:cardBackgroundColor="@color/white"
        app:cardCornerRadius="@dimen/activity_horizontal_margin"
        app:cardElevation="0dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.533">

        <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="111dp"
        android:orientation="vertical"
        >

        <EditText
        android:id="@+id/email"
        android:layout_width="319dp"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:ems="10"
        android:hint="email"
        android:fontFamily="@font/bold"
        android:textColor="@color/white"
        android:inputType="textEmailAddress"
        android:textColorHint="@color/black" />

        <EditText
        android:id="@+id/password"
        android:layout_width="319dp"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:textColor="@color/black"
        android:hint="password"
        android:fontFamily="@font/bold"
        android:ems="10"
        android:inputType="textPassword"
        android:textColorHint="@color/black"
        app:endIconMode="password_toggle" />
        </LinearLayout>
        </androidx.cardview.widget.CardView>
         */
    }
}