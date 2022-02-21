package br.com.mob4pay.lf.projeto.base;

public abstract class ModelDto<E extends Model>
{
    public abstract E dtoToModel();
}
