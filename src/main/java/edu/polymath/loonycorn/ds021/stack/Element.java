package edu.polymath.loonycorn.ds021.stack;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
class Element<T> {

  @Getter
  T data;

  @Getter
  Element<T> next;
}
