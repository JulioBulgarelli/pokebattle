package br.com.ada.f1rst.pokebattle;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext
@ExtendWith({MockitoExtension.class})
public abstract class BaseTestContext {}
