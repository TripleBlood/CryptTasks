package rc4.utils;

/*
*  По-сути просто обертка для обычного числа-элемента,
*  где добавлен идентификатор, который показывает был ли переставлен элемент или нет
 */
public class ElementWithSubstDet {

    private int value;
    private boolean isSubst; //эта переменная показывает, переставлен ли элемент или нет

    public ElementWithSubstDet(int value) {
        this.value = value;
        this.isSubst = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isSubst() {
        return isSubst;
    }

    public void setSubst(boolean subst) {
        isSubst = subst;
    }
}
