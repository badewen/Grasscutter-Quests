package emu.grasscutter.game.ability.actions;

import emu.grasscutter.data.binout.AbilityModifier.AbilityModifierAction;
import emu.grasscutter.game.ability.Ability;
import emu.grasscutter.game.ability.AbilityAction;
import emu.grasscutter.game.ability.AbilityActionHandler;
import emu.grasscutter.game.entity.GameEntity;

@AbilityAction(AbilityModifierAction.Type.ExecuteGadgetLua)
public class ActionExecuteGadgetLua extends AbilityActionHandler {
    @Override
    public boolean execute(Ability ability, AbilityModifierAction action) {
        GameEntity owner = ability.getOwner();

        if(owner.getEntityController() != null) {
            owner.getEntityController().onClientExecuteRequest(owner, action.param1, action.param2, action.param3);
            return true;
        }

        return false;
    }
}
