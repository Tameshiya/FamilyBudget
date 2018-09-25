package jp.rei.andou.familybudget.presentation.router;

import android.app.Activity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Screen {

    private final Class<? extends Activity> clazz;

}
