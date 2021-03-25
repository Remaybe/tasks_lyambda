import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {

        //   1. Распространенные операции Stream. Реализуйте:
        //a. Функцию сложения чисел, то есть int addUp(Stream<Integer>
        //numbers).
        //b. Функцию, которая получает исполнителя и возвращает спи-
        //сок строк, содержащих имена и место происхождения.
        //c. Функцию, которая получает альбомы и возвращает список
        //альбомов, содержащих не более трех произведений.

        // 3.1A
        List<Integer> num = new ArrayList<>();
        num.add(2);
        num.add(4);
        num.add(6);
        Stream<Integer> numbers = num.stream();
        System.out.println(addUp(numbers));

        // 3.1B
        Singers armstrong = new Singers("Armstrong", "USA");
        Singers rams = new Singers("Rammstein", "German");
        List<Singers> singers = new ArrayList<>(Arrays.asList(armstrong, rams));
        List<String> singersAndCountryList = toStringArray(singers);
        singersAndCountryList.stream().forEach(value -> System.out.print(value + " "));
        System.out.println(" ");

        // 3.1C
        Albums armstrongAlbums = new Albums(new ArrayList<>(Arrays.asList("sss", "ewew", "wewew", "dwdwew")));
        Albums ramsAlbums = new Albums(new ArrayList<>(Arrays.asList("sss", "ewew")));
        Albums anotherAlbums = new Albums(new ArrayList<>(Arrays.asList("s22ss", "e33wew")));
        List<Albums> listAlbums = new ArrayList<>(Arrays.asList(armstrongAlbums, ramsAlbums, anotherAlbums));
        List<Albums> filteredAlbums = filterAlbums(listAlbums);
        filteredAlbums.stream().forEach(value -> System.out.println(value));

    }

    // 3.1A
    public static int addUp(Stream<Integer> numbers) {
       return numbers.mapToInt(value -> value).sum();
    }

    // 3.1B
    public static List<String> toStringArray(List<Singers> singers) {
        return singers.stream()
                .flatMap(singer -> Stream.of(singer.getName(), singer.getCountry()))
                .collect(toList());
    }

    // 3.1C
    public static List<Albums> filterAlbums(List<Albums> albums) {
        return albums.stream()
                .filter(value -> value.getSongs().size() < 3)
                .collect(toList());
    }

}
