package Intuit;
import java.util.*;

// https://leetcode.com/problems/find-in-mountain-array/
public class findInMountainArray {
    public static void main(String[] args) {
        int n = 7;
        MountainArray mountain = new MountainArray(n);
        mountain.add(0, 1);
        mountain.add(1, 2);
        mountain.add(2, 3);
        mountain.add(3, 4);
        mountain.add(4, 5);
        mountain.add(5, 3);
        mountain.add(6, 1);

        int target = 3;

        System.out.println(findInMountainArray(target, mountain));
    }

    public static class MountainArray {
        private int[] arr;

        public MountainArray(int n) {
            arr = new int[n];
        }

        public void add(int index, int val) {
            arr[index] = val;
        }

        public int get(int index) {
            return arr[index];
        }

        public int length() {
            return arr.length;
        }
    }

    private static int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakElement(mountainArr);
        int firstTry = orderAgonisticBinarySearch(mountainArr, 0, peak, target);

        if(firstTry != -1) {
            return firstTry;
        }

        return orderAgonisticBinarySearch(mountainArr, peak, mountainArr.length() - 1, target);
    }

    private static int orderAgonisticBinarySearch(MountainArray mountainArr, int s, int e, int target) {

        boolean isAsc = mountainArr.get(s) < mountainArr.get(e);

        while(s <= e) {
            int mid = s + (e - s) / 2;

            if(mountainArr.get(mid) == target) {
                return mid;
            }

            if(isAsc) {
                if(mountainArr.get(mid) > target) {
                    e = mid - 1;
                }

                else {
                    s = mid + 1;
                }
            }

            else {
                if(mountainArr.get(mid) < target) {
                    e = mid - 1;
                }

                else  {
                    s = mid + 1;
                }
            }
        }

        return -1;
    }

    private static int peakElement(MountainArray mountainArr) {
        int s = 0;
        int e = mountainArr.length() - 1;

        while(s < e) {
            int mid = s + (e - s) / 2;
            if(mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                e = mid;
            }

            else if(mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                s = mid + 1;
            }

            else {
                return mid;
            }
        }

        return s;
    }

}
