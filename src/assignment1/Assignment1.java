/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;


import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.scene.shape.Circle; 
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import java.util.Scanner;

public class Assignment1 extends Application { 
   @Override 
       public void start(Stage stage) {
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root ,600, 600);
        stage.setScene(scene);

        //Creating a circle object         
        Circle circle = null;
        Scanner sc=new Scanner(System.in);  
        int num= sc.nextInt();
        
        int i=0;
        int oldx=0,oldy=0;
        int firstx=0,firsty=0;
            while(i<num){
                circle = new Circle();
                int x=sc.nextInt();
                circle.setCenterX(x);
                int y=sc.nextInt();
                circle.setCenterY(y);
                if(i==0)
                {
                    firstx=x;firsty=y; //save coordinates of the first circle
                }
                circle.setRadius(5); 
                circle.setStroke(Color.RED);
                if(i!=0){
                    //if there is only one circle don't draw  any line
                        Line line = new Line(oldx, oldy,   x,   y);
                        root.getChildren().add(line);
                    }

                
                
                root.getChildren().add(circle);
                oldx=x;oldy=y;
                i++;
                    if(i==num){ //last circle so draw last line between the first and last circle
                        Line line = new Line(firstx, firsty,   x,   y);
                        System.out.println(firstx + ' '+ firsty + ' '+ x + ' '+ y);
                        root.getChildren().add(line);
                    }
            }

        scene.setRoot(root);
        stage.show();

    }
   public static void main(String args[]){ 
      launch(args); 
   } 
}  