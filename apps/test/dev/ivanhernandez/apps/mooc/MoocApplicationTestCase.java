package dev.ivanhernandez.apps.mooc;

import org.springframework.transaction.annotation.Transactional;
import dev.ivanhernandez.apps.ApplicationTestCase;

@Transactional("mooc-transaction_manager")
public abstract class MoocApplicationTestCase extends ApplicationTestCase {
}
