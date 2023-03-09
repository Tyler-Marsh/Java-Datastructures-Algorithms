import java.util.PriorityQueue;
/*
* Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
* */
class KClosestSolution {


    // store a max heap
    // when K is greater than the limit keep popping off the maximum values

    static int[][] KClosest(int[][] points, int k) {

        // link hashmp to index of point

        // > 0  n1 b4 n2
        // < 0 n2 b4 n1
        // 0 == same order
        // store distance then reference to original array
        PriorityQueue<double[]> q = new PriorityQueue<>((num1, num2) -> {
            // bigger has to be first
            if (num1[0] > num2[0]) {
                return -1;
            }
            if (num1[0] < num2[0]) {
                return 1;
            }
            return 0;
        });


        double distance;
        for (int i = 0; i < points.length; i++) {
            distance = Math.sqrt(Math.pow(Math.abs(points[i][0] -0),2) + Math.pow(Math.abs(points[i][1]-0),2));
            q.add(new double[]{distance, i});
        }
        while (q.size() > k) {
            q.poll();
        }
        int[][] ans = new int[k][2];
        int j = 0;
        double[] temp;
        while (q.size() > 0) {
            temp = q.remove();
            ans[j] = points[(int)temp[1]];
            j++;
        }
     return ans;
    }
    public static void main(String[] args) {

        int[][] points1 = new int[2][2];
        points1[0] = new int[]{1,3};
        points1[1] = new int[]{-2,2};

        int[][] points2 = new int[3][2];
        points2[0] = new int[]{3,3};
        points2[1] = new int[]{5,-1};
        points2[2] = new int[]{-2,4};

        System.out.println(KClosest(points1, 1));

        System.out.println(KClosest(points2, 2));
        
    }
}