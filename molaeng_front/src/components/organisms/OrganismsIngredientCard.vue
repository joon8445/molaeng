<template>
  <div id="ingredientCard">
    <v-card id="card" class="mx-auto mb-9 rounded-lg">
      <v-card-actions id="title" :class="{ 'rounded-lg': !show }">
        <v-card-title class="dark--text font-weight-bold" text>
          {{ ingredientCategory.ingredientTitle }}
        </v-card-title>
        <v-spacer></v-spacer>
        <v-btn icon @click="show = !show">
          <v-icon>{{ show ? "mdi-chevron-up" : "mdi-chevron-down" }}</v-icon>
        </v-btn>
      </v-card-actions>
      <v-expand-transition>
        <div v-if="show">
          <v-card-text>
            <ingredient-tag-list
              :ingredientList="ingredientCategory.ingredientList"
              :keyWord="keyWord"
            />
          </v-card-text>
        </div>
      </v-expand-transition>
    </v-card>
  </div>
</template>

<script>
import IngredientTagList from "../molecules/MoleculesIngredientTagList.vue";

export default {
  name: "IngredientCard",
  props: {
    ingredientCategory: Object,
    keyWord: String,
  },
  components: {
    IngredientTagList,
  },
  data: () => ({
    show: false,
  }),
  watch: {
    keyWord(newValue) {
      let temp = false;
      if (newValue == "") {
        temp = false;
      } else {
        this.ingredientCategory.ingredientList.forEach((e) => {
          if (e.ingredientName.indexOf(this.keyWord) >= 0) {
            temp = true;
          }
        });
      }
      this.show = temp;
    },
  },
};
</script>

<style>
.v-card,
table {
  width: 86%;
  max-width: 351px;
}

#title {
  background-color: #fef3c6;
}
#card {
  box-shadow: 0px 5px 10px rgb(91 87 75 / 20%);
  max-width: 351px;
}
#ingredientCard #title {
  height: 60px;
}
</style>
