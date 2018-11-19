package jp.rei.andou.familybudget.domain.onboarding;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import io.reactivex.functions.Function;
import jp.rei.andou.familybudget.data.repositories.onboarding.OnboardingRepository;
import jp.rei.andou.familybudget.data.repositories.onboarding.SessionRepository;

import static jp.rei.andou.familybudget.domain.onboarding.DatabaseOnboardingInteractorTest.Validator.validateItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Every.everyItem;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseOnboardingInteractorTest {

    private DatabaseOnboardingInteractor databaseOnboardingInteractor;

    @Before
    public void setup() {
        OnboardingRepository onboardingRepository = mock(OnboardingRepository.class);
        SessionRepository sessionRepository = mock(SessionRepository.class);
        databaseOnboardingInteractor = new DatabaseOnboardingInteractor(onboardingRepository,
                sessionRepository);
    }


    public static class Validator<T> extends TypeSafeMatcher<T> {

        private final Function<T, Boolean> function;

        private Validator(Function<T, Boolean> interactor) {
            this.function = interactor;
        }

        @Factory
        public static <T> Matcher<T> validateItem(Function<T, Boolean> function) {
            return new Validator<>(function);
        }

        @Override
        protected boolean matchesSafely(T item) {
            try {
                return function.apply(item);
            } catch (Exception e) {
                throw new RuntimeException("Error occurred on testing of element: " + item + ".\n" + e.getMessage());
            }
        }

        @Override
        public void describeTo(Description description) {
//       TODO pass argument of description to factory method description.appendText("positive integer greater than 10000");
        }
    }

    @Test
    public void caseInsensitiveShorterThat5FamilyNameIsInvalid() {
        List<String> validInputs = Arrays.asList("Aabcd", "AbCdEf");
        List<String> invalidInputs = Arrays.asList("", "A bbbb", "aAbc");
        assertThat(validInputs, everyItem(
                validateItem(familyName -> databaseOnboardingInteractor.validateFamily(familyName))
        ));
        assertThat(invalidInputs, not(everyItem(
                validateItem(familyName -> databaseOnboardingInteractor.validateFamily(familyName))
        )));
    }

    @Test
    public void onlyEnglishCharactersIsValid() {
        List<String> invalidInputs = Arrays.asList("Abcd1", "A12345", "12345", "123456",
                "Ac-*&^%$#@!\\|/", "A-b-c-dee");
        assertThat(invalidInputs, not(everyItem(
                validateItem(familyName -> databaseOnboardingInteractor.validateFamily(familyName))
        )));
        assertTrue(databaseOnboardingInteractor.validateFamily("abcde"));
    }

    @Test
    public void atLeastTenThousandIsMinimalValidDeposit() {
        List<String> invalidInputs = Arrays.asList("1000", "9999", "1", "0", "000000");
        List<String> validInputs = Arrays.asList("10000", "12335476", "12345");
        assertThat(invalidInputs, not(everyItem(
                validateItem(integer -> databaseOnboardingInteractor.validateDeposit(integer)))
        ));
        assertThat(validInputs, everyItem(
                validateItem(integer -> databaseOnboardingInteractor.validateDeposit(integer)))
        );
    }

    @Test
    public void onlyPositiveIntegerGreaterThatTenThousandIsValid() {
        List<String> invalidInputs = Arrays.asList("-10000", "10000.123", "10000,123");
        assertThat(invalidInputs, everyItem(not(
                validateItem(deposit -> databaseOnboardingInteractor.validateDeposit(deposit))
        )));
    }

    @Test
    public void validDepositIsOnlyPositiveOverTenThousandNumeric() {
        List<String> invalidInputs = Arrays.asList("Hello World", "HelloWorld", "10000a",
                "10000yen", "百万円", "yen10000", "1O000", "lOOOO", "1_000_000"
        );
        assertThat(invalidInputs, everyItem(not(
                validateItem(deposit -> databaseOnboardingInteractor.validateDeposit(deposit))
        )));
        assertTrue(databaseOnboardingInteractor.validateDeposit("10000"));
    }

}