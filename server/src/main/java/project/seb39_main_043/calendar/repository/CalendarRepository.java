package project.seb39_main_043.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.seb39_main_043.calendar.entity.Calendar;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

}
