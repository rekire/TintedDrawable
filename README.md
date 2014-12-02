TintedDrawable
==============

A small helper class for tinting drawables.

Here is a small example how to tint the EditText like in Lollipop:

    myTextEdit.setBackgroundDrawable(new TintedDrawable(getResources().getDrawable(R.drawable.abc_edit_text_material)) {
        @Override
        protected int getColor(boolean isPressed, boolean isFocused, boolean isActive) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = getContext().getTheme();
            if(myTextEdit.hasFocus()) {
                if(theme.resolveAttribute(R.attr.colorAccent, typedValue, true)) {
                    return typedValue.data;
                }
            }
            return getResources().getColor(R.color.bright_foreground_disabled_material_light);
        }
    });

##License
This code is licensed under the [Rekisoft Public License][rkspl].
See [http://www.rekisoft.eu/licenses/rkspl.html][rkspl] for more informations.

  [rkspl]: http://www.rekisoft.eu/licenses/rkspl.html