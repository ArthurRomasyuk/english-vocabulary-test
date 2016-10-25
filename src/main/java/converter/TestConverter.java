package converter;

import controller.TestBean;
import model.AnswersEntity;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "testConverter")
public class TestConverter implements Converter {

    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String answerId) {
        ValueExpression vex =
                ctx.getApplication().getExpressionFactory()
                        .createValueExpression(ctx.getELContext(),
                                "#{testBean}", TestBean.class);

        TestBean testBean = (TestBean) vex.getValue(ctx.getELContext());
        return testBean.getAnswer(Integer.valueOf(answerId));
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object answer) {
        return String.valueOf(((AnswersEntity) answer).getId());
    }

}
