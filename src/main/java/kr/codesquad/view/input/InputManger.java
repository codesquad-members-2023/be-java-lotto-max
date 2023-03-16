package kr.codesquad.view.input;

import java.util.Optional;

public interface InputManger<T> {
	Optional<T> askClient();
}
