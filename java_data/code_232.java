package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Crawler {


    private static final Pattern libraryPattern = Pattern.compile("(([a-zA-Z0-9]|\\.|-|_)+)(\\.js)");
    private static final Pattern libraryName = Pattern.compile("([a-zA-Z0-9]|-)*");

    
    public static void main(String[] args) {
        final String searchTerm = Arrays.stream(args)
                .collect(Collectors.joining(" "));
        System.out.println("Provided search term: " + searchTerm);
        final List<String> googleSearchResults = getGoogleSearchResults(searchTerm);
       
        final Map<String, Long> collect = googleSearchResults.parallelStream()
                .map(Crawler::parsePageToFindLibs)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));
        
        collect.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(5)
                .forEach(entry ->
                        System.out.println(entry.getKey()
                                + " was used "
                                + entry.getValue()
                                + " times in results pages"));
    }

    
    public static List<String> getGoogleSearchResults(String searchTerm) {
        return Arrays.asList("https:                "https:                "https:                "https:                "https:                "https:                "https:                "https:                "https:                "https:                "https:    }

    
    public static List<String> parsePageToFindLibs(String url) {
        List<String> result = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(UrlWrapper.getInputStream(url), StandardCharsets.UTF_8))) {
            String line;
            while ((line = in.readLine()) != null) {
                final Matcher matcher = libraryPattern.matcher(line);
                if (matcher.find()) {
                    
                    final Matcher nameMatcher = libraryName.matcher(matcher.group(0));
                    if (nameMatcher.find()) {
                        result.add(nameMatcher.group(0));
                    }
                }
            }
        } catch (IOException e) {
            
            e.printStackTrace();
            return Collections.emptyList();
        }
        return result;
    }


    
    static class UrlWrapper {
        public static InputStream getInputStream(String url) throws IOException {
            return new URL(url).openStream();
        }
    }
}