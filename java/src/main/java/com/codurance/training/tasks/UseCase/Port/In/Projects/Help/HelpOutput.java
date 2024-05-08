package com.codurance.training.tasks.UseCase.Port.In.Projects.Help;

import tw.teddysoft.ezddd.cqrs.usecase.CqrsOutput;

public class HelpOutput extends CqrsOutput<HelpOutput> {

    public HelpDto helpDto;

    public static HelpOutput create(){
        return new HelpOutput();
    }

}
