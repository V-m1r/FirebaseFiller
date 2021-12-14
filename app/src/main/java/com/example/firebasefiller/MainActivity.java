package com.example.firebasefiller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button trends, categories;
    int counter, counterCats = 0;
    TextView tv;

    private static String[] descriptionTrainingCats = {
            "This is a great training for you cuz you are fat",
            "This is a great training for you cuz you are fat"
    };
    private static String[] videosDisDes = {
            "Squats are great!",
            "Jumps Are awesome"
    };

    private static String[] videosDisTitle = {
            "Squats",
            "Jumps"
    };

    private static String[] videosDisVideoURL = {
            "https://firebasestorage.googleapis.com/v0/b/fitness-pro-91916.appspot.com/o/1_squat.mp4?alt=media&token=bb4b28e7-4355-4c03-833b-6da8fdb93757",
            "https://firebasestorage.googleapis.com/v0/b/fitness-pro-91916.appspot.com/o/2_jumping_jacks.mp4?alt=media&token=9b3d5785-a35e-40fc-a0ea-56960396aac0"
    };
    private static String[] imgTrainCats = {
            "https://firebasestorage.googleapis.com/v0/b/fitness-pro-91916.appspot.com/o/1_squat.mp4?alt=media&token=bb4b28e7-4355-4c03-833b-6da8fdb93757",
            "https://firebasestorage.googleapis.com/v0/b/fitness-pro-91916.appspot.com/o/2_jumping_jacks.mp4?alt=media&token=9b3d5785-a35e-40fc-a0ea-56960396aac0",
            "https://firebasestorage.googleapis.com/v0/b/fitness-pro-91916.appspot.com/o/2_jumping_jacks.mp4?alt=media&token=9b3d5785-a35e-40fc-a0ea-56960396aac0"

    };
    private static String[] videosCategoriesVideoURL = {
            "https://firebasestorage.googleapis.com/v0/b/fitness-pro-91916.appspot.com/o/1_squat.mp4?alt=media&token=bb4b28e7-4355-4c03-833b-6da8fdb93757",
            "https://firebasestorage.googleapis.com/v0/b/fitness-pro-91916.appspot.com/o/2_jumping_jacks.mp4?alt=media&token=9b3d5785-a35e-40fc-a0ea-56960396aac0",
            "https://firebasestorage.googleapis.com/v0/b/fitness-pro-91916.appspot.com/o/2_jumping_jacks.mp4?alt=media&token=9b3d5785-a35e-40fc-a0ea-56960396aac0"

    };
    private static String[] videosCategoriesTitle = {
            "Squats", "Rest", "Jumping"
    };
    private static String[] videosCategoriesCountdown = {
            "60", "5", "60"
    };
    private static String[] titlesCats = {

            "Special 1",
            "Special 2",

    };

    private static String[] videosCountDown = {
            "60", "5", "60"

    };
    private static String[] videosTv = {
            "Squats", "Rest", "Jumping"

    };
    private static String[] videosVideoURLs = {
            "https://firebasestorage.googleapis.com/v0/b/fitness-pro-91916.appspot.com/o/1_squat.mp4?alt=media&token=bb4b28e7-4355-4c03-833b-6da8fdb93757",
            "https://firebasestorage.googleapis.com/v0/b/fitness-pro-91916.appspot.com/o/2_jumping_jacks.mp4?alt=media&token=9b3d5785-a35e-40fc-a0ea-56960396aac0",
            "https://firebasestorage.googleapis.com/v0/b/fitness-pro-91916.appspot.com/o/2_jumping_jacks.mp4?alt=media&token=9b3d5785-a35e-40fc-a0ea-56960396aac0"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.counterOfTrainings);
        trends = findViewById(R.id.buttonTrends);
        categories = findViewById(R.id.buttonCategories);
        trends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putForTrends();
            }
        });
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putForCategory();
            }
        });

    }

    public void putForCategory() {
        DatabaseReference trendingExercises = FirebaseDatabase.getInstance().getReference().child("categories");
        trendingExercises.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    counterCats += 1;
                    Log.e("Counter: ", counterCats + "");
                }

                if (counterCats <= 9) {
                    DatabaseReference category = FirebaseDatabase.getInstance().getReference().child("categories").child("category" + ((counterCats >= 1) ? counterCats + 1 : 1));

                    String titleOfCateogry = "Fitness Lite";
                    String turlOfCategory = "https://evofitness.ch/wp-content/uploads/2019/01/Crossfit-EVO-Fitness-1200x675.jpg";

                    category.child("title").setValue(titleOfCateogry);
                    category.child("turl").setValue(turlOfCategory);

                    for (int i = 0; i < titlesCats.length; i++) {
                        category.child("cat").child("training" + (i + 1)).setValue(new TrainingModelCats(imgTrainCats[i], titlesCats[i], descriptionTrainingCats[i]));

                    }
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("categories").child("category" + ((counterCats >= 1) ? counterCats + 1 : 1)).child("cat").child("training" + titlesCats.length);
                    String index = "";
                    for (int i = 0; i < videosDisTitle.length; i++) {
                        index = i >= 10 ? "00" + i : "000" + i;
                        ref.child("videosDis").child(index).setValue(new VidModel(videosDisVideoURL[i], videosDisTitle[i], videosDisDes[i]));

                    }
                    for (int i = 0; i < videosCategoriesTitle.length; i++) {
                        ref.child("videosDis").child(index).child("videos").child(i >= 10 ? "ex00" + i : "ex000" + i).
                                setValue(new VidModel(videosCategoriesVideoURL[i], videosCategoriesTitle[i], videosCategoriesCountdown[i]));


                    }
                    String difLevel = "Difficult2";
                    String types = "Abs2";
                    String expandedDis = "Exp2";
                    String totalTime = "10 mins2";


                    ref.child("videosDis").child(index).child("workoutDis").setValue(new WorkoutDis(expandedDis, totalTime, difLevel, types));

                    for (int i = 0; i < videosCategoriesTitle.length; i++) {
                        if (!videosCategoriesTitle[i].equals("Rest"))
                            ref.child("videosDis").child(index).child("workoutDis").child("videosDis").child("vid1_"+(i==0?1+"":i+"")).setValue(new VidModel(videosCategoriesVideoURL[i], videosCategoriesTitle[i], videosCategoriesCountdown[i]));


                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }







    public void putForTrends() {

        DatabaseReference trendingExercises = FirebaseDatabase.getInstance().getReference().child("trending_exercises");
        trendingExercises.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    counter += 1;
                    Log.e("Counter: ", counter + "");
                }
                if (counter <= 8) {


                    DatabaseReference training = FirebaseDatabase.getInstance().getReference().child("trending_exercises").child("t" + ((counter >= 1) ? counter + 1 : 1));

                    String title = "Title 1";
                    String description = "Deascription 1";
                    String turl = "https://firebasestorage.googleapis.com/v0/b/fitness-pro-91916.appspot.com/o/Trener.webp?alt=media&token=e5013974-fa18-4d20-bcae-3f5e4c185aea";

                    ExerciseModel exerciseModel = new ExerciseModel(turl, description, title);
                    training.setValue(exerciseModel);
                    tv.setText("Current counter: " + counter);
                    if (videosCountDown.length == videosTv.length && videosTv.length == videosVideoURLs.length) {


                        for (int i = 0; i < videosCountDown.length; i++) {
                            training.child("videos").child(i >= 10 ? "00" + i : "000" + i).setValue(new VidModel(videosVideoURLs[i], videosTv[i], videosCountDown[i]));


                        }
                        String difLevel = "Difficult";
                        String types = "Abs";
                        String expandedDis = "Exp";
                        String totalTime = "10 mins";

                        DatabaseReference trainingDis = FirebaseDatabase.getInstance().getReference().child("trending_exercises").child("t" + ((counter >= 1) ? counter + 1 : 1));
                        trainingDis.child("workoutDis").setValue(new WorkoutDis(expandedDis, totalTime, difLevel, types));

                        for (int i = 0; i < videosCountDown.length; i++) {
                            if (!videosTv[i].equals("Rest"))
                                trainingDis.child("workoutDis").child("videosDis").child("vid1_"+(i==0?1+"":i+"")).setValue(new VidModel(videosVideoURLs[i], videosTv[i], videosCountDown[i]));


                        }
                    } else {
                        Log.e("Mistake Byatch!: ", "countdown length: " + videosCountDown.length + " tv length: " + videosTv.length + " videosURL length: " + videosVideoURLs.length);


                    }
                } else {
                    Toast.makeText(MainActivity.this, "Exceedin num of allowed trending ex", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}