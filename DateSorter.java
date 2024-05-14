
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 package sample;

 import java.time.LocalDate;
 import java.util.Collection;
 import java.util.List;

 /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 * Implement in single class. Don't chane constructor and signature method.
 */

/**
 * The implementation of this method should sort dates.
 * The output should be in the following order:
 * Dates with an 'r' in the month,
 * sorted ascending (first to last),
 * then dates without an 'r' in the month,
 * sorted descending (last to first).
 * For example, October dates would come before May dates,
 * because October has an 'r' in it.
 * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
 * would sort to
 * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
 *
 //@param unsortedDates - an unsorted list of dates
 * @return the collection of dates now sorted as per the spec
 */
public class DateSorter {

    public static void main(String[] args) {
        Task511.DateSorter sorter = new Task511.DateSorter();
        List<LocalDate> unsortedDates = List.of(
                LocalDate.of(2004, 7, 1),
                LocalDate.of(2005, 1, 2),
                LocalDate.of(2007, 1, 1),
                LocalDate.of(2032, 5, 3)
        );
        System.out.println("Unsorted :");
        unsortedDates.forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println("Sorted : ");
        Collection<LocalDate> sortedDates = sorter.sortDates(unsortedDates);
        sortedDates.forEach(x -> System.out.print(x + " "));
    }
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> listWithSorteddate = new ArrayList<>();
        List<LocalDate> listWithUnSorteddate = new ArrayList<>();
        for (LocalDate unsortedDate : unsortedDates) {
            int month = unsortedDate.getMonthValue();
            if (month <= 4 || month >= 9) {
                listWithSorteddate.add(unsortedDate);
            } else listWithUnSorteddate.add(unsortedDate);
        }
        listWithSorteddate.sort(Comparator.comparingInt(x -> x.getMonth().getValue()));
        listWithUnSorteddate.sort(Comparator.comparingInt(x -> x.getMonth().getValue()));
        List<LocalDate> result = new ArrayList<>(listWithSorteddate);
        result.addAll(listWithUnSorteddate);
        return result;
    }

}