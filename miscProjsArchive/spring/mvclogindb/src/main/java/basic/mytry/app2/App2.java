package basic.mytry.app2;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class App2 {
    public static void main(String[] args) {
        SpringApplication.run(App2.class, args);
    }
}

@Component
class BookingCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        for (Booking b : this.bookingRepository.findAll())
            System.out.println(b.toString());
    }

    @Autowired
    BookingRepository bookingRepository;
}

interface BookingRepository extends JpaRepository<Booking, Long> {
    Collection<Booking> findByBookingName(String bookingName);
}

@Entity
class Booking {
    public Booking(){};
    @Id
    @GeneratedValue
    private Long id;
    private String bookingName;

    public Booking(String bookingName) {
        super();
        this.setBookingName(bookingName);
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

}

@RestController
class BookingRestController {

    @RequestMapping("/bookings")
    Collection<Booking> bookings() {
        return this.bookingRepository.findAll();
    }

    @Autowired
    BookingRepository bookingRepository;
}