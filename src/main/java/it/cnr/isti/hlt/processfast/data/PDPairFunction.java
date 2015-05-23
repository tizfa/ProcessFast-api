package it.cnr.isti.hlt.processfast.data;

import it.cnr.isti.hlt.processfast.core.TaskDataContext;
import it.cnr.isti.hlt.processfast.utils.Pair;

public interface PDPairFunction<In,Key, Value> {
	 Pair<Key, Value> call(TaskDataContext ctx, In par1);
}
