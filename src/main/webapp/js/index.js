function splitIntoStrings(values) {
  if (values === undefined) return [];
  return values.toString()
               .split(/[\s,;]+/);
}

const tags = $("#tags");
const displayedTags = $("#displayTags");
let tagList;

tags.keyup(() => {
    displayedTags.empty();
    tagList = splitIntoStrings(tags.val());
    for(var i = 0; i < tagList.length; i++) {
        $(`<div>${tagList[i]}</div>`).appendTo(displayedTags);
    }
});
