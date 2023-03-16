package kr.codesquad.view;

import java.util.Optional;

public interface InputManagerInterface<T> {
	Optional<T> askClient();
}
