package edu.polymath.loonycorn.ds021.queue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
class Element<T> {

  @Getter
  T data;

  @Getter
  @Setter
  Element<T> next;
}
