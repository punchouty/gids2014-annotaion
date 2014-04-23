package com.sapient.gids.checker;

import static java.lang.annotation.ElementType.TYPE_USE;

import java.lang.annotation.Target;

@Target(value={TYPE_USE})
public @interface Critical {

}
