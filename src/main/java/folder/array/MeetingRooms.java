package folder.array;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
    @Data
    static class Meeting {
        int start;
        int end;
        int pos;

        public Meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    // ans :       1 +  0  + 1 +  0  +  0  + 0
    public static void main(String[] args) {
        int[] start = {100, 200, 300, 400, 400, 350};
        int[] end =   {210, 280, 450, 310, 500, 450};

        int meetings = getMeetings(start, end);
        System.out.println("ans =  " + meetings);
    }

    private static int getMeetings(int[] start, int[] end) {
        List<Meeting> meetingList = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meetingList.add(new Meeting(start[i], end[i], i + 1));
        }

        Collections.sort(meetingList, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if (o1.getEnd() < o2.getEnd()) {
                    return -1;
                } else if (o1.getEnd() > o2.getEnd()) {
                    return 1;
                } else if (o1.pos < o2.pos) {
                    return -1;
                }
                return 0;
            }
        });
        // System.out.println(meetingList);
        int result = 0;
        int endTime = 0;
        for (int k = 0; k < meetingList.size(); k++) {
            Meeting m = meetingList.get(k);
            if (m.start > endTime) {
                result = result + 1;
                endTime = m.end;
                System.out.println("" + (k + 1));
            }
        }
        return result; //1 + 3 + 5
    }
}

