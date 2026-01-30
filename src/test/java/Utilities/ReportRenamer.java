package Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportRenamer {
    public static void main(String[] args) {
        String timestamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
        File original = new File("target/cucumber-reports.html");
        File renamed = new File("target/cucumber-reports-" + timestamp + ".html");

        if (!original.exists()) {
            System.out.println("⚠️ Report file not found: " + original.getPath());
            return;
        }

        try {
            Files.move(original.toPath(), renamed.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("✅ Report renamed to: " + renamed.getName());
        } catch (IOException e) {
            System.err.println("❌ Failed to rename report: " + e.getMessage());
        }
        System.out.println("🔧 ReportRenamer executed");
    }
}