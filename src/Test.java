import java.util.*;

public class Test {


    static ArrayList<String> ls = new ArrayList<>();

    static void levelAndOptions(int arr[], int id, String res, int sum, int target) {
        if (arr.length - 1 < id) {
            if (target == sum) {
                System.out.println(res);
                //return;
            }
            return;
        }


        levelAndOptions(arr, id + 1, res + arr[id] + " ,", sum + arr[id], target);
        levelAndOptions(arr, id + 1, res, sum, target);
    }

    public static void mazePath(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;

        int dp[][] = new int[m][n];

        int iniPath = 0;
        for (int i = maze.length - 1; i >= 0; i--) {

            for (int j = maze[i].length - 1; j >= 0; j--) {
                if (i == maze.length - 1) {
                    iniPath = maze[i][j] + iniPath;
                    dp[i][j] = iniPath;
                } else {
                    if (j == maze[i].length - 1) {
                        dp[i][j] = dp[i + 1][j] + maze[i][j];
                    } else {
                        dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + maze[i][j];
                    }
                }

            }

        }

        System.out.println(dp[0][0]);
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i <= tempList.size(); i++) {
                tempList.add(i, nums[tempList.size()]);
                backtrack(list, tempList, nums);
                tempList.remove(i);
            }
        }
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    //List<Integer>  ex  = new ArrayList<>();
    static List<List<Integer>> ex = new ArrayList<>();

    private static void getSubSet(int[] nums, int idx, boolean bool, String res, List<Integer> subList) {

        if (nums.length - 1 < idx) {

            System.out.print(res);
            List<Integer> s = new ArrayList<>(subList);
            ex.add(s);
            return;
        }

        //subList.add(nums[idx]);
        getSubSet(nums, idx + 1, subList.add(nums[idx]), res + nums[idx], subList);
        subList.remove(subList.size() - 1);
        getSubSet(nums, idx + 1, false, res, subList);

    }


    static class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class PairSort implements Comparator<Pair> {

        public int compare(Pair s1, Pair s2) {
            if (s1.key < s2.key)
                return 1;
            else if (s1.key > s2.key)
                return -1;
            return 0;
        }

    }

    static void getSwap(int a, int b, int arr[]) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static boolean callSubSetSum(boolean dp[][], int sum, int[] nums) {

        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (nums[i - 1] <= j) {
                    System.out.println(i + "==" + j + "--" + dp[i][j - nums[i - 1]] + " " + dp[i][j - 1]);
                    dp[i][j] = (dp[i][j - nums[i - 1]] || dp[i][j - 1]);
                } else {

                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String args[]) {
        String res = "";
        String s = "3[a2[c]]";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            } else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }


        }
    }
}