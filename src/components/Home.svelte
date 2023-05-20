<script lang="ts">
  import { redirect } from "../stores/redirect";

  function onClick(event: MouseEvent) {
    redirect(event, "/story");
  }
</script>

<button on:click={onClick} class="text-onPrimary">My story</button>
