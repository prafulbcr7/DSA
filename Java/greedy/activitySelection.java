
/* 
Activity Selection 
You are given n activities with their start and end times. Select the maximum number of activities 
that can be performed by a single person, assuming that a person can only work on a single 
activity at a time. Activities are sorted according to end time. 
start [10, 12, 201 
ans 2 (AO & A2) 
end = [20, 25, 301 
*/


import java.util.*;

public class activitySelection {

    // TC : O(n)
    public static void main(String args[]){
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};

        // End Time Sorted
        int maxAct = 1;
        List<Integer> act = new ArrayList<>();
        act.add(0);
        int lastEndTime = end[0];

        for(int i=1; i<end.length; i++){
            if(start[i] >= lastEndTime){
                maxAct++;
                act.add(i);
                lastEndTime = end[i];
            }
        }

        
        // Print them
        System.out.println("Max Activities : " + maxAct);
        for(int i=0; i< act.size(); i++){
            System.out.print("A" + act.get(i) + " " );
        }
        System.out.println();

        NotSorted();
    }

    //TC : O(nlogn)
    public static void NotSorted(){
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        
        //Sorting
        int[][] activities = new int[end.length][3];
        for(int i=0; i< start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        //sort
        Arrays.sort(activities, Comparator.comparingDouble( o -> o[2]));

        //
        List<Integer> ans = new ArrayList<>();
        int maxAct = 1;
        ans.add(activities[0][0]);
        int lastEndTime = activities[0][2];

        for(int i=0; i<end.length; i++){
            if(activities[i][1] >= lastEndTime){
                maxAct++;
                ans.add(activities[i][0]);
                lastEndTime = activities[i][2];
            }
        }

        // Print them
        System.out.println("Max Activities : " + maxAct);
        for(int i=0; i< ans.size(); i++){
            System.out.print("A" + ans.get(i) + " " );
        }
        System.out.println();

    }

}