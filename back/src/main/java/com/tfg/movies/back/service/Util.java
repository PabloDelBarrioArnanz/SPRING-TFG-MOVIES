package com.tfg.movies.back.service;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Util {

  public static <T> UnaryOperator<T> peek(Consumer<T> c) {
    return x -> {
      c.accept(x);
      return x;
    };
  }
}
