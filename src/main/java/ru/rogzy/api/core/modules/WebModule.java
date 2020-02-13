package ru.rogzy.api.core.modules;

import com.codeborne.selenide.CollectionCondition;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import ru.rogzy.api.core.annotations.web.Education;
import ru.rogzy.api.core.annotations.web.WhoWeServe;

import java.util.Arrays;

import static com.codeborne.selenide.CollectionCondition.exactTexts;

public class WebModule extends AbstractModule {

    @Override
    protected void configure() {
        this.install(new CommonModule());
    }

    @Provides
    @WhoWeServe
    CollectionCondition getWhoWeServe() {
        return exactTexts(Arrays.asList(
                "Students",
                "Instructors",
                "Book Authors",
                "Professionals",
                "Researchers",
                "Institutions",
                "Librarians",
                "Corporations",
                "Societies",
                "Journal Editors",
                "Government"));
    }

    @Provides
    @Education
    CollectionCondition getEducation() {
        return exactTexts(Arrays.asList(
                "Assessment, Evaluation Methods",
                "Classroom Management",
                "Conflict Resolution & Mediation",
                "Curriculum Tools",
                "Education & Public Policy",
                "Educational Research",
                "General Education",
                "Higher Education",
                "Information & Library Science",
                "Special Education",
                "Special Topics",
                "Vocational Technology"));
    }
}
