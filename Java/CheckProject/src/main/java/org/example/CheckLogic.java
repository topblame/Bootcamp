package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CheckLogic {
    private final Set<LocalDate> DateLogic = new HashSet<>();

    public boolean daychecklogic() {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        if(now.isAfter(LocalTime.of(2, 0)) && now.isBefore(LocalTime.of(9, 0))) {
            return false; // 오전 2시 ~ 9시 출석체크 불가능
        }
        if(DateLogic.contains(today)) {
            return false; //오늘 출석했을시 출석 불가능.
        }

        DateLogic.add(today);
        return true;
    }
    public int CountMonth(Set<LocalDate> checkdays) {
        Month month = LocalDate.now().getMonth();
        int year = LocalDate.now().getYear();
        int count = 0;

        for(LocalDate date : checkdays) {
            if(date.getMonth() == month && date.getYear() == year) {
                count++;
            }
        }

        return count;
    }

    public Set<LocalDate> getDateLogic() {
        return DateLogic;
    }
}
