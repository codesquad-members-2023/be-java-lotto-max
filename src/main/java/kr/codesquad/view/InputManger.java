package kr.codesquad.view;

import java.util.Optional;

public interface InputManger<T> {
	Optional<T> askClient();
}
