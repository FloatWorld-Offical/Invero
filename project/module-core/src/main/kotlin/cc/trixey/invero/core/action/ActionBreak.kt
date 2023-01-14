package cc.trixey.invero.core.action

import cc.trixey.invero.core.Context
import java.util.concurrent.CompletableFuture

/**
 * Invero
 * cc.trixey.invero.core.action.ActionBreak
 *
 * @author Arasple
 * @since 2023/1/14 12:54
 */
class ActionBreak : Action {

    override fun run(context: Context): CompletableFuture<Boolean> {
        return COMPLETABLE_FALSE
    }

    companion object {

        val COMPLETABLE_FALSE = CompletableFuture<Boolean>().also { it.complete(false) }

    }

}