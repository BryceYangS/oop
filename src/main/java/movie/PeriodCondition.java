package movie;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        LocalDateTime screeningStartTime = screening.getStartTime();
        LocalTime screeningLocalTime = screeningStartTime.toLocalTime();
        return screeningStartTime.getDayOfWeek().equals(dayOfWeek) &&
                startTime.compareTo(screeningLocalTime) <= 0 &&
                endTime.compareTo(screeningLocalTime) >= 0;
    }
}
