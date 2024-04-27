package dev.ivanhernandez.apps.mooc;

import dev.ivanhernandez.apps.ApplicationTestCase;
import org.springframework.transaction.annotation.Transactional;

@Transactional("mooc-transaction_manager")
public abstract class MoocApplicationTestCase extends ApplicationTestCase {
}
