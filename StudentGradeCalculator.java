import java.util.Scanner;


public class StudentGradeCalculator{
public static void main(String args []){
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of Students: ");
    int n = sc.nextInt();

    int[] marks=new int[n];
    int totalMarks =0;

    // input marks
    for(int i=0; i<n; i++){
        System.out.println("Enter marks for Subject" + (i+1) + ":");
        marks[i] = sc.nextInt();


        // validate marks
        if(marks[i]<0 || marks[i]>100){
            System.out.println("Invalid marks entered. Plese enter marks between 0 and 100.");
            i--; 
            continue;
        }
        totalMarks += marks[i];
    }

    // Calculate average percentage

    double percentage = (double) totalMarks / n;

    // grade calcu
    String grade;
    if(percentage >=90){
        grade = "A+";
    }
    else if(percentage >=80){
        grade = "A";
    }
    else if(percentage >=70){
        grade = "B+";
    }
    else if(percentage >=60){
        grade = "B";
    }
    else if(percentage >=50){
        grade = "C";
    }
    else if(percentage >=40){
        grade ="D";
    }
    else{
        grade ="F (Fait)";
    }

    // Display results
    System.out.println("\n____Result____");
    System.out.println("Total Marks:" +totalMarks);
    System.out.println("Average Percentage: "+ percentage +"%");
    System.out.println("grade:"+grade);

    sc.close();

    

}
}