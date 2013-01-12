package com.example.StyledHtmlTextView;

import android.content.Context;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import android.text.style.QuoteSpan;
import android.text.style.TextAppearanceSpan;

public class StyledHtml {
    public static Spanned fromHtml(Context context, String html) {
        SpannableStringBuilder builder = (SpannableStringBuilder) Html.fromHtml(html);
        return replaceQuotes(context, builder);
    }

    private static Spanned replaceQuotes(Context context, SpannableStringBuilder builder) {
        QuoteSpan[] quotes = builder.getSpans(0, builder.length(), QuoteSpan.class);
        int start;
        int end;
        for(QuoteSpan quote : quotes){
            start = builder.getSpanStart(quote);
            end = builder.getSpanEnd(quote);
            TextAppearanceSpan tas = new TextAppearanceSpan(context, R.style.quoteText);
            builder.setSpan(tas, start, end, 0);
            LeadingMarginSpan margin = new LeadingMarginSpan.Standard((int)context.getResources().getDimension(R.dimen.quoteMargin));
            builder.setSpan(margin, start, end, 0);
            builder.removeSpan(quote);
        }
        return builder;
    }
}
