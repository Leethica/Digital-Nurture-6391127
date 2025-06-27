public class WeatherServiceTestManual{
    interface WeatherAPI {
        String getCurrentWeather(String city);
    }

    static class WeatherService {
        private WeatherAPI api;

        public WeatherService(WeatherAPI api) {
            this.api = api;
        }

        public String getWeatherReport(String city) {
            return "Weather in " + city + ": " + api.getCurrentWeather(city);
        }
    }

    static class MockWeatherAPI implements WeatherAPI {
        @Override
        public String getCurrentWeather(String city) {
            // Stubbing with predefined response
            if (city.equals("Chennai")) {
                return "Sunny, 35°C";
            } else if (city.equals("Delhi")) {
                return "Cloudy, 28°C";
            }
            return "Data not available";
        }
    }

    public static void main(String[] args) {
        WeatherAPI mockApi = new MockWeatherAPI();
        WeatherService service = new WeatherService(mockApi);

        String report1 = service.getWeatherReport("Chennai");
        if (report1.equals("Weather in Chennai: Sunny, 35°C")) {
            System.out.println("testChennai passed");
        } else {
            System.out.println("testChennai failed: " + report1);
        }

        String report2 = service.getWeatherReport("Delhi");
        if (report2.equals("Weather in Delhi: Cloudy, 28°C")) {
            System.out.println("testDelhi passed");
        } else {
            System.out.println("testDelhi failed: " + report2);
        }

        String report3 = service.getWeatherReport("Mumbai");
        if (report3.equals("Weather in Mumbai: Data not available")) {
            System.out.println("testMumbai passed");
        } else {
            System.out.println("testMumbai failed: " + report3);
        }
    }
}
