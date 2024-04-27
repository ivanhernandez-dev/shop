package dev.ivanhernandez.apps.backoffice;

import org.springframework.transaction.annotation.Transactional;
import dev.ivanhernandez.apps.ApplicationTestCase;

@Transactional("backoffice-transaction_manager")
public abstract class BackofficeApplicationTestCase extends ApplicationTestCase {
}
