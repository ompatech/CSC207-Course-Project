package use_case.mutate_seeding;

import data_access.APIDataAccessObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MutateSeedingInteractorTest {

    @Test
    void mutateFailureTest() {
        List<Integer> finalSeeds = new ArrayList<>();
        MutateSeedingInputData inputData = new MutateSeedingInputData(finalSeeds);

        // Create new setSeeding method which throws an exception for this test
        APIDataAccessObject failDataAccessInterface = new APIDataAccessObject() {
            @Override
            public void setSeeding(List<Integer> seeding) {
                throw new UnsupportedOperationException("Failure");
            }
        };

        MutateSeedingOutputBoundary failPresenter = new MutateSeedingOutputBoundary() {
            @Override
            public void prepareSuccessView() {
                fail("Use case success is unexpected.");
            }

            @Override
            public void switchToMainMenuView() {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Something went wrong with the API call, try again.", error);
            }
        };

        MutateSeedingInputBoundary interactor = new MutateSeedingInteractor(failDataAccessInterface, failPresenter);
        interactor.execute(inputData);
    }

}