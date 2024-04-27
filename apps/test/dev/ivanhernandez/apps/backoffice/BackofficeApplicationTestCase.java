package dev.ivanhernandez.apps.backoffice;

import dev.ivanhernandez.apps.ApplicationTestCase;
import org.springframework.transaction.annotation.Transactional;

@Transactional("backoffice-transaction_manager")
public abstract class BackofficeApplicationTestCase extends ApplicationTestCase {
}
