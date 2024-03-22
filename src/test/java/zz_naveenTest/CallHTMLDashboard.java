package zz_naveenTest;

public class CallHTMLDashboard {
    public static void createAndShowDashboard() {
        String path = "E:\\HTMLFolder"; // Specify the path to your HTML files
        HTMLDashboard dashboard = new HTMLDashboard(path);
        dashboard.setVisible(true); // Make the dashboard visible
    }
    public static void main(String args[]) {
    	createAndShowDashboard();
    }

    // You can add other methods or functionality to this class as needed
}
