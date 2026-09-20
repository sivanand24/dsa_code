import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervalProblem {
    //merge intervals
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> res = new ArrayList<>();
        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        for(int i = 1; i<intervals.length; i++){
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if(end1 >= start2){
                end1 = Math.max(end1, end2);
                continue;
            }
            res.add(new int[]{start1,end1});
            start1 = start2;
            end1 = end2;
        }
        res.add(new int[]{start1,end1});
        return res.toArray(new int[res.size()][]);
    }
    //insert intervals
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> temp = new ArrayList<>();
        boolean start = false;
        for(int i = 0; i < intervals.length; i++){
            if(start == false && newInterval[0] <= intervals[i][0]){
                temp.add(newInterval);
                start = true;
            }
            temp.add(intervals[i]);
        }
        if(start == false){
            temp.add(newInterval);
        }
        ArrayList<int[]> res = new ArrayList<>();

        int start1 = temp.get(0)[0];
        int end1 = temp.get(0)[1];

        for(int i = 1; i<temp.size(); i++){
            int start2 = temp.get(i)[0];
            int end2 = temp.get(i)[1];

            if(end1 >= start2){
                start1 = start1;
                end1 = Math.max(end1, end2);
                continue;
            }
            res.add(new int[]{start1,end1});
            start1 = start2;
            end1 = end2;
        }
        res.add(new int[]{start1,end1});
        return res.toArray(new int[res.size()][]);
    }
    //Interval List Intersection
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> res = new ArrayList<>();
        int i =0,j=0;
        while( i< firstList.length && j < secondList.length){
            int start1 = firstList[i][0];
            int end1   = firstList[i][1];
            int start2 = secondList[j][0];
            int end2   = secondList[j][1];
            if(start1 <= start2){
                if(end1 >= start2){
                    int s = Math.max(start1, start2);
                    int e = Math.min(end1, end2);
                    res.add(new int[]{s,e});
                }
            }
            else {
                if(end2 >=start1){
                    int s = Math.max(start1, start2);
                    int e = Math.min(end1, end2);
                    res.add(new int[]{s,e});
                }
            }
            if(end1<=end2){
                i++;
            }
            else {
                j++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
