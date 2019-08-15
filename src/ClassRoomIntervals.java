import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This problem was asked by Snapchat.
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */

public class ClassRoomIntervals {

    public int minimumRoomsRequired ( int[][] intervals ) {

        // the minimum number of rooms to be returned
        int minimumRooms = 0;

        if ( intervals == null || intervals.length < 1 ) {
            return 0;
        }

        int row = 0;
        int len = intervals.length;

        // List holding all the interval times with their types
        List<IntervalType> allTimes = new ArrayList<>();

        while ( row < len ) {
            allTimes.add(new IntervalType(intervals[row][0], 's'));
            allTimes.add(new IntervalType(intervals[row][1], 'e'));
            row++;
        }

        allTimes.sort( new IntervalSorter());
        int curr_rooms = 0;

        for ( IntervalType intervalType : allTimes ) {
            if ( intervalType.type == 's') {
                curr_rooms++;
            } else {
                if ( curr_rooms > minimumRooms ) {
                    minimumRooms = curr_rooms;
                }
                curr_rooms--;
            }
        }

        return minimumRooms;
    }

    
    public class IntervalSorter implements Comparator<IntervalType> {

        @Override
        public int compare(IntervalType o1, IntervalType o2) {
            return o1.getTime()-o2.getTime();
        }
    }


    /**
     * Class that maps the interval time to the interval type ( start or end ).
     */
    class IntervalType {
        int time;
        char type;

        public IntervalType(int time, char type) {
            this.time = time;
            this.type = type;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public char getType() {
            return type;
        }

        public void setType(char type) {
            this.type = type;
        }
    }
}
