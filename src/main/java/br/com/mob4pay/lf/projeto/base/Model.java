package br.com.mob4pay.lf.projeto.base;

public abstract class Model<R extends ModelDto>
{
    public abstract R modelToDto();
}
